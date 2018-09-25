package eventos;

import entidades.portao.PortaoSimples;
import interfaces.IBotaoPressionado;

public class BotaoPressionado implements IBotaoPressionado {

    public void botaoPressionado(PortaoSimples portaoSimples) {
        portaoSimples.getStatusAtualPortao().portaoFechadoOuAberto(portaoSimples);//Verifica se o portão está totalmente Aberto ou Totalmente Fechado.
        switch (portaoSimples.getStatusAtualPortao()) {
            case ABRINDO:
            case FECHANDO:
                portaoSimples.pausar();
                break;
            case TOTALMENTE_FECHADO:
                portaoSimples.abrir();
                break;
            case TOTALMENTE_ABERTO:
                portaoSimples.fechar();
                break;
            case PARADO:
                portaoSimples.despausar();
                break;
        }
    }
}
