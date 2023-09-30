package OperacaoBasica;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    /*atributo, no map sempre terá uma key e um valor.
    HashMap é o mais comum
    no Map usamos o put em vez do add, mas ambos servem para a mesma coisa
    isEmpty serve para verificar dentro
    put serve para adicionar ou atualizar*/
    private Map<String, Integer> agendaContatosMap;

    public AgendaContatos() {
        this.agendaContatosMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        agendaContatosMap.put(nome, telefone);
    }

    public void removerContato(String nome){
        if(!agendaContatosMap.isEmpty()){
            agendaContatosMap.remove(nome);
        }
    }

    public void exibirContato(){
        System.out.println(agendaContatosMap);
    }

    public Integer pesquisarPorNome(String nome){
        Integer numeroPorNome = null;
        if(!agendaContatosMap.isEmpty()){
            agendaContatosMap.get(nome);  //que nesse caso é a key.
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Camila", 272819);
        agendaContatos.adicionarContato("Camila", 565758);
        agendaContatos.adicionarContato("Camila Cavalcante", 272819);
        agendaContatos.adicionarContato("Camila DIO", 445566);
        agendaContatos.adicionarContato("Maria Silva", 112233);
        agendaContatos.adicionarContato("Camila", 666444);

        agendaContatos.exibirContato();
        agendaContatos.removerContato("Maria Silva");
        agendaContatos.exibirContato();

        System.out.println("O numero é " + agendaContatos.pesquisarPorNome("Camila DIO"));
    }
}
