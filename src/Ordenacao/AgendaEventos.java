package Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static java.time.Month.*;

public class AgendaEventos {
    //atributos

    private Map<LocalDate, Eventos> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEventos(LocalDate data, String nome, String atracao){
        Eventos eventos = new Eventos(nome, atracao);
        eventosMap.put(data, eventos);

    }

    public void exibirAgenda(){
        Map<LocalDate, Eventos> eventosTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreeMap);
    }

    //
    public void obterProximoEvento(){
        /*Set<LocalDate> dateSet = eventosMap.keySet();
        Collections<Eventos> values = eventosMap.values();
        São métodos independentes, não dá para usar os dois ao mesmo tempo, pois não retornam juntos.
        Queremos a data do próximo evento de uma maneira prática, então usaremos o LocalDate.now
        Ele retorna a data atual.
        Explicando o entrySet:
        Retorna um set, que cada elemento é de um tipo único.
        Ele sabe apontar a chave e o valor correspondente. Diferentemente dos métodos acima, que só retorna um ou outro.
        */
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Eventos> eventosTreeMap = new TreeMap<>(eventosMap);
        for(Map.Entry<LocalDate, Eventos> entry : eventosMap.entrySet()){
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                System.out.println("O próximo evento: " + entry.getValue() + " acontecerá na data " + entry.getKey());
                break;
            }
        }

    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        agendaEventos.adicionarEventos(LocalDate.of(2022, JULY, 15) , "Evento 1", "Atração 1");
        agendaEventos.adicionarEventos(LocalDate.of(2022, AUGUST, 7) , "Evento 2", "Atração 2");
        agendaEventos.adicionarEventos(LocalDate.of(2023, NOVEMBER, 10) , "Evento 3", "Atração 3");

        agendaEventos.exibirAgenda();
        agendaEventos.obterProximoEvento();

    }
}
