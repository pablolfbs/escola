package com.pablo.escola.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HorarioSalaService {

    public static class BlocoHorario {
        private LocalTime inicio;
        private LocalTime fim;

        public BlocoHorario(LocalTime inicio, LocalTime fim) {
            this.inicio = inicio;
            this.fim = fim;
        }

        public boolean conflita(BlocoHorario outro) {
            return !this.fim.isBefore(outro.inicio) && !this.inicio.isAfter(outro.fim);
        }

        public LocalTime getInicio() { return inicio; }
        public LocalTime getFim() { return fim; }

        @Override
        public String toString() {
            return inicio + " - " + fim;
        }
    }

    // Exemplo de blocos padrão (blocos de 2h entre 8h e 18h)
    public static List<BlocoHorario> gerarBlocosPadrao(LocalTime inicio, LocalTime fim, int duracaoEmMinutos) {
        List<BlocoHorario> blocos = new ArrayList<>();
        LocalTime atual = inicio;
        while (atual.plusMinutes(duracaoEmMinutos).isBefore(fim) || atual.plusMinutes(duracaoEmMinutos).equals(fim)) {
            blocos.add(new BlocoHorario(atual, atual.plusMinutes(duracaoEmMinutos)));
            atual = atual.plusMinutes(duracaoEmMinutos);
        }
        return blocos;
    }

    public static List<BlocoHorario> calcularBlocosLivres(List<BlocoHorario> blocosOcupados, List<BlocoHorario> blocosPadrao) {
        return blocosPadrao.stream()
            .filter(padrao -> blocosOcupados.stream().noneMatch(padrao::conflita))
            .collect(Collectors.toList());
    }

    // Simulação de uso
    public static void main(String[] args) {
        // Blocos ocupados da sala em um determinado dia
        List<BlocoHorario> ocupados = List.of(
            new BlocoHorario(LocalTime.of(8, 0), LocalTime.of(10, 0)),
            new BlocoHorario(LocalTime.of(14, 0), LocalTime.of(16, 0))
        );

        // Gerar blocos padrão entre 08:00 e 18:00 com duração de 2 horas
        List<BlocoHorario> blocosPadrao = gerarBlocosPadrao(LocalTime.of(8, 0), LocalTime.of(18, 0), 120);

        List<BlocoHorario> livres = calcularBlocosLivres(ocupados, blocosPadrao);

        System.out.println("Blocos livres:");
        livres.forEach(System.out::println);
    }
}

