/**
 * FURMAX TEMPLATE
 * # FURMAX TEMPLATE REST api specifications Le api REST richiedono di effettuare il login tramite il servizio relativo, per ottenere il token di autenticazione. Le chiamate agli altri servizi devono contenere il token nell'header Authorization, es :    nome header: Authorization /   valore header: Bearer token   ---  ### Paginazione  La paginazione puo' richiedere al massimo 300 elementi  I servizi che prevedono paginazione hanno sempre in input  * pageSize - numero di elementi per pagina - default 20  * pageNumber - numero di pagina - default 1 
 *
 * OpenAPI spec version: 0.0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


export interface Paginazione { 
    /**
     * dimensione della pagina di risultati
     */
    dimensionePagina?: number;
    /**
     * numero della pagina
     */
    numeroPagina?: number;
    /**
     * numero totale delle pagine
     */
    totalePagine?: number;
    /**
     * numero totale degli elemtni
     */
    totaleElementi?: number;
}
