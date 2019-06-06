package lapr.project.utils;

import java.io.Serializable;

/**
 *
 *
 */
public class Tempo implements Serializable, Comparable<Tempo>{

    private int hora = 0;
    private int minuto = 0;
    private int segundo = 0;

    /**
     *
     * Constrói uma instância de Tempo com os parametros hora, minuto, segundo.
     *
     * @param hora Hora
     * @param minuto Minuto
     * @param segundo Segundo
     */
    public Tempo(int hora, int minuto, int segundo) {
        if (hora < 0 || hora > 23) {
            throw new HoraInvalidaException("Hora " + hora + " é inválida!!");
        }
        if (minuto < 0 || hora > 59) {
            throw new MinutoInvalidoException("Minuto " + minuto + " é inválido!!");
        }
        if (segundo < 0 || segundo > 59) {
            throw new SegundoInvalidoException("Segundo " + segundo + " é inválido!!");
        }
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    /**
     *
     * Devolve a hora do Tempo.
     *
     * @return Hora
     */
    public int getHora() {
        return hora;
    }

    /**
     *
     * Devolve o minuto do Tempo
     *
     * @return Minuto
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     *
     * Devolve o segundo do Tempo.
     *
     * @return Segundo
     */
    public int getSegundo() {
        return segundo;
    }

    /**
     *
     * Modifica a hora do Tempo
     *
     * @param hora Hora
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     *
     * Modifica o minuto do Tempo
     *
     * @param minuto Minuto
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    /**
     *
     * Modifica o segundo do Tempo
     *
     * @param segundo Segundo
     */
    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    /**
     *
     * Devolve o Tempo no formato 24h.
     *
     * @return Tempo no formato 24h
     */
    public String getTempo24h() {
        String tempo = hora + ":" + minuto + ":" + segundo;
        return tempo;
    }

    /**
     *
     * Devolve a descrição textual do Tempo no formato: hora:minuto:segundo
     *
     * @return Descrição textual do Tempo no formato: hora:minuto:segundo
     */
    @Override
    public String toString() {
        return this.hora + "h : " + this.minuto + "min";
    }

    /**
     *
     * Devolve o Tempo no formato 12h.
     *
     * @return Tempo no formato 12h
     */
    public String getTempo12h() {
        String tempo12h = converter24hPara12h();
        return tempo12h;
    }

    /**
     *
     * Converte o Tempo do formato 24h para 12h.
     *
     * @return Tempo no formato 12h
     */
    private String converter24hPara12h() {
        String tempoConv = "::";
        boolean flagPM = false;
        int hora12h = this.hora;
        if (this.hora > 12) {
            hora12h -= 12;
            flagPM = true;
        }
        if (flagPM) {
            tempoConv = hora12h + ":" + this.minuto + ":" + this.segundo + " PM";
        } else {
            tempoConv = hora12h + ":" + this.minuto + ":" + this.segundo + " AM";
        }
        return tempoConv;
    }

    /**
     *
     * Soma 1 segundo à instância de Tempo
     *
     */
    public void somarSegundo() {
        this.segundo += 1;
        if (this.segundo > 60) {
            this.segundo = 0;
            this.minuto += 1;
        } else {
            if (this.minuto == 60) {
                this.minuto = 0;
                this.hora += 1;
            } else {
                if (this.hora == 24) {
                    this.hora = 0;
                }
            }
        }
    }

    /**
     *
     * Retorna true/false caso a instância maior seja maior/menos que o
     * parametro tempo 2
     *
     * @param tempo2 - parametro do tipo Tempo para comparação
     * @return True/false caso a instância maior seja maior/menos que o
     * parametro tempo 2
     */
    public boolean tempoMaior(Tempo tempo2) {
        boolean result = false;

        if (this.hora > tempo2.hora) {
            result = true;
        } else {
            if (this.hora == tempo2.hora) {
                if (this.minuto > tempo2.minuto) {
                    result = true;
                } else {
                    if (this.minuto == tempo2.minuto) {
                        if (this.segundo > tempo2.segundo) {
                            result = true;
                        }
                    }
                }
            }
        }

        return result;
    }

    /**
     *
     * Retorna true/false caso a instância maior seja maior/menos que o tempo
     * inserido por parametros
     *
     * @param hora Hora
     * @param minuto Minuto
     * @param segundo Segundo
     * @return True/false caso a instância maior seja maior/menos que o tempo
     * inserido por parametros
     */
    public boolean tempoMaior(int hora, int minuto, int segundo) {
        boolean result = false;

        if (this.hora > hora) {
            result = true;
        } else {
            if (this.hora == hora) {
                if (this.minuto > minuto) {
                    result = true;
                } else {
                    if (this.segundo > segundo) {
                        result = true;
                    }
                }
            }
        }

        return result;
    }

    /**
     *
     * Retorna a diferença entre a instância de Tempo e a instância de tempo
     * inserido por parametro
     *
     * @param tempo2 Tempo2
     * @return Diferença entre a instância de Tempo e a instância de tempo
     * inserido por parametro
     */
    public String diferencaTempo(Tempo tempo2) {
        String result = "::";
        int difHora = 0;
        int difMin = 0;
        int difSeg = 0;

        double segTotal = diferencaTempoSegundos(tempo2);

        difHora = (int) (segTotal / 3600);
        segTotal -= difHora * 3600;
        difMin = (int) (segTotal / 60);
        segTotal -= difMin * 60;
        difSeg = (int) segTotal;

        result = difHora + ":" + difMin + ":" + difSeg;

        return result;
    }

     /**
     *
     * Retorna a diferença entre a instância de Tempo e a instância de tempo
     * inserido por parametro
     *
     * @param tempo2 Tempo2
     * @return Diferença entre a instância de Tempo e a instância de tempo
     * inserido por parametro
     */
    public double diferencaTempoSegundos(Tempo tempo2) {
        String result = "::";
        double tempoTotal;
        double tempo2Total;

        tempoTotal = this.segundo + this.minuto * 60 + this.hora * 3600;
        tempo2Total = tempo2.segundo + tempo2.minuto * 60 + tempo2.hora * 3600;

        //return (Math.abs(tempoTotal - tempo2Total));
        return tempoTotal - tempo2Total;
    }
    
    /**
     * 
     * Retorna true/false caso a instância maior seja maior/menos que o tempo
     * inserido por parametros
     * 
     * @param oOutroTempo Tempo a comparar
     * @return True/false caso a instância maior seja maior/menos que o tempo
     * inserido por parametros
     */
    @Override
    public int compareTo(Tempo oOutroTempo) {
        double iDif = this.diferencaTempoSegundos(oOutroTempo);
        if (iDif > 0) {
            return 1;
        }else if(iDif == 0){
            return 0;
        }else{
            return -1;
        }
    }
}
