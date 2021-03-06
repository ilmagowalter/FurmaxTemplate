window.swaggerSpec={
  "swagger" : "2.0",
  "info" : {
    "version" : "0.0.1",
    "title" : "FURMAX TEMPLATE",
    "description" : "# FURMAX TEMPLATE REST api specifications\nLe api REST richiedono di effettuare il login tramite il servizio relativo, per ottenere il token di autenticazione.\nLe chiamate agli altri servizi devono contenere il token nell'header Authorization, es :\n\n  nome header: Authorization /\n  valore header: Bearer token\n \n---\n\n### Paginazione\n\nLa paginazione puo' richiedere al massimo 300 elementi\n\nI servizi che prevedono paginazione hanno sempre in input\n * pageSize - numero di elementi per pagina - default 20\n * pageNumber - numero di pagina - default 1\n"
  },
  "basePath" : "/furmaxtemplate/rest",
  "schemes" : [ "http", "https" ],
  "securityDefinitions" : {
    "APIKeyHeader" : {
      "type" : "apiKey",
      "in" : "header",
      "name" : "Authorization"
    }
  },
  "host" : "localhost:8080",
  "paths" : {
    "/login/" : {
      "post" : {
        "summary" : "Effettua il login",
        "description" : "Valida le credenziali fornite ed effettua l'accesso, ritornando la apiKey da utilizzare nelle altre chiamate",
        "tags" : [ "login" ],
        "consumes" : [ "application/json" ],
        "produces" : [ "application/json" ],
        "parameters" : [ {
          "name" : "autenticazione",
          "in" : "body",
          "required" : true,
          "schema" : {
            "$ref" : "#/definitions/Autenticazione"
          }
        } ],
        "responses" : {
          "200" : {
            "description" : "successo, token di autenticazione",
            "schema" : {
              "$ref" : "#/definitions/InformazioniAccesso"
            }
          },
          "400" : {
            "description" : "errore di autenticazione",
            "schema" : {
              "$ref" : "#/definitions/ErroreGenerico"
            }
          }
        }
      }
    },
    "/utente/" : {
      "get" : {
        "security" : [ {
          "APIKeyHeader" : [ ]
        } ],
        "summary" : "ricerca all'interno degli utenti utenti",
        "description" : "ritorna l'elenco degli utenti, paginato e filtrato secondo input",
        "tags" : [ "utenti" ],
        "produces" : [ "application/json" ],
        "parameters" : [ {
          "name" : "pageSize",
          "in" : "query",
          "description" : "numero di elementi per pagina",
          "type" : "integer",
          "format" : "int64",
          "default" : 20,
          "minimum" : 1,
          "maximum" : 300
        }, {
          "name" : "pageNumber",
          "in" : "query",
          "description" : "numero della pagina da ritornare",
          "type" : "integer",
          "format" : "int64",
          "default" : 1,
          "minimum" : 1
        } ],
        "responses" : {
          "200" : {
            "description" : "elenco degli utenti",
            "schema" : {
              "$ref" : "#/definitions/UtentiPaginati"
            }
          }
        }
      },
      "post" : {
        "security" : [ {
          "APIKeyHeader" : [ ]
        } ],
        "summary" : "crea un utente",
        "description" : "crea un utente",
        "tags" : [ "utenti" ],
        "produces" : [ "application/json" ],
        "parameters" : [ {
          "name" : "utenti",
          "in" : "body",
          "description" : "utenti da creare",
          "required" : true,
          "schema" : {
            "$ref" : "#/definitions/Utente"
          }
        } ],
        "responses" : {
          "200" : {
            "description" : "utente salvato in banca dati",
            "schema" : {
              "$ref" : "#/definitions/Utente"
            }
          },
          "400" : {
            "description" : "input non valido",
            "schema" : {
              "$ref" : "#/definitions/ErroreGenerico"
            }
          }
        }
      }
    },
    "/utente/{idUtente}" : {
      "put" : {
        "security" : [ {
          "APIKeyHeader" : [ ]
        } ],
        "summary" : "modifica un utente esistente",
        "description" : "modifica un utente esistente",
        "tags" : [ "utenti" ],
        "produces" : [ "application/json" ],
        "parameters" : [ {
          "name" : "idUtente",
          "in" : "path",
          "description" : "idUtente da modificare",
          "required" : true,
          "minimum" : 0,
          "type" : "integer",
          "format" : "int64"
        }, {
          "name" : "utente",
          "in" : "body",
          "description" : "dettagli dell'utente da modificare",
          "required" : true,
          "schema" : {
            "$ref" : "#/definitions/Utente"
          }
        } ],
        "responses" : {
          "200" : {
            "description" : "utente salvato in banca dati",
            "schema" : {
              "$ref" : "#/definitions/Utente"
            }
          },
          "400" : {
            "description" : "input non valido",
            "schema" : {
              "$ref" : "#/definitions/ErroreGenerico"
            }
          }
        }
      }
    }
  },
  "definitions" : {
    "Paginazione" : {
      "type" : "object",
      "properties" : {
        "dimensionePagina" : {
          "type" : "integer",
          "format" : "int64",
          "description" : "dimensione della pagina di risultati"
        },
        "numeroPagina" : {
          "type" : "integer",
          "format" : "int64",
          "description" : "numero della pagina"
        },
        "totalePagine" : {
          "type" : "integer",
          "format" : "int64",
          "description" : "numero totale delle pagine"
        },
        "totaleElementi" : {
          "type" : "integer",
          "format" : "int64",
          "description" : "numero totale degli elemtni"
        }
      }
    },
    "ErroreGenerico" : {
      "type" : "object",
      "properties" : {
        "codice" : {
          "type" : "string",
          "description" : "codice di errore http"
        },
        "codiceErrore" : {
          "type" : "string",
          "description" : "codice di errore del messaggio corrispondente"
        },
        "descrizione" : {
          "type" : "string"
        }
      }
    },
    "RispostaGenerica" : {
      "type" : "object",
      "properties" : {
        "codice" : {
          "type" : "string",
          "description" : "codice di risposta"
        },
        "descrizione" : {
          "type" : "string"
        }
      }
    },
    "Utente" : {
      "type" : "object",
      "properties" : {
        "idUtente" : {
          "type" : "integer",
          "format" : "int64"
        },
        "nomeUtente" : {
          "type" : "string"
        },
        "email" : {
          "type" : "string"
        },
        "nome" : {
          "type" : "string"
        },
        "cognome" : {
          "type" : "string"
        },
        "telefono" : {
          "type" : "string"
        },
        "abilitato" : {
          "type" : "boolean",
          "description" : "true indica abilitato, false disabilitato"
        },
        "dataUltimoCambioPassword" : {
          "description" : "data ultimo cambio password espressa in millisecondi",
          "type" : "integer",
          "format" : "int64"
        },
        "dataUltimaConnessione" : {
          "description" : "data ultima connessione espressa in millisecondi",
          "type" : "integer",
          "format" : "int64"
        }
      }
    },
    "UtentiPaginati" : {
      "type" : "object",
      "properties" : {
        "data" : {
          "type" : "array",
          "items" : {
            "$ref" : "#/definitions/Utente"
          }
        },
        "paginazione" : {
          "$ref" : "#/definitions/Paginazione"
        }
      }
    },
    "Autenticazione" : {
      "type" : "object",
      "properties" : {
        "username" : {
          "type" : "string"
        },
        "password" : {
          "type" : "string"
        }
      }
    },
    "InformazioniAccesso" : {
      "type" : "object",
      "properties" : {
        "tipoToken" : {
          "type" : "string",
          "description" : "descrive la tipologia di token, es. Bearer"
        },
        "scadenza" : {
          "type" : "integer",
          "format" : "int64",
          "description" : "tempo di scadenza del token, in minuti"
        },
        "token" : {
          "type" : "string"
        },
        "utente" : {
          "$ref" : "#/definitions/Utente"
        }
      }
    }
  }
}