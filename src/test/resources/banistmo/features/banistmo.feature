#Author: juan.raga@sophossolutions
Feature: Abrir archivo pdf de la pagina de Banistmo
  Patricio cliente de banistmo
  Necesita abrir un archivo sobre FATCA
  Para saber mas sobre esta  ley

  Background: Ir a la pagina web de banistmo
    Given "Patricio" desea ir a la página de banistmo

  Scenario Outline: descargar archivo pdf de forma exitosa
    When Va a la seccion FATCA & CRS y descarga el archivo pdf de autocertificación unificado
    Then Valida que el titulo del archivo sea <mensaje>

    Examples:
      | mensaje                                     |
      | "AUTO-CERTIFICACIÓN FISCAL" |

