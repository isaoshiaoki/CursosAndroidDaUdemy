package com.android.iam.linhadeonibusjson;

import java.util.Date;

public class PosicaoOnibusDTO
{
   private String posicaoOnibus;
   private Date dataHora;
   private String ordem;
   private String linha;
   private Double latitude;
   private Double longitude;
   private Double velocidade;
   private Integer direcao;



   public String getPosicaoOnibus() {
        return posicaoOnibus;
    }

    public void setPosicaoOnibus(String posicaoOnibus) {
        this.posicaoOnibus = posicaoOnibus;
    }
   
   public Date getDataHora()
   {
      return dataHora;
   }
   public void setDataHora(Date dataHora)
   {
      this.dataHora=dataHora;
   }
   public String getOrdem()
   {
      return ordem;
   }
   public void setOrdem(String ordem)
   {
      this.ordem=ordem;
   }
   public String getLinha()
   {
      return linha;
   }
   public void setLinha(String linha)
   {
      this.linha=linha;
   }
   public Double getLatitude()
   {
      return latitude;
   }
   public void setLatitude(Double latitude)
   {
      this.latitude=latitude;
   }
   public Double getLongitude()
   {
      return longitude;
   }
   public void setLongitude(Double longitude)
   {
      this.longitude=longitude;
   }
   public Double getVelocidade()
   {
      return velocidade;
   }
   public void setVelocidade(Double velocidade)
   {
      this.velocidade=velocidade;
   }
   public Integer getDirecao()
   {
      return direcao;
   }
   public void setDirecao(Integer direcao)
   {
      this.direcao=direcao;
   }
   
   

    @Override
    public String toString() {
        return "PosicaoOnibusDTO: " + getPosicaoOnibus()
                + "\nData: " + getDataHora()
                + "\nOrdem: " + getOrdem()
                + "\nLinha: " + getLinha()
                + "\nLatitude: " + getLatitude()
                + "\nLongitude:" + getLongitude()
                + "\nVelocidade: " + getVelocidade()
                + "\nDirecao: " + getDirecao();


    }






}
