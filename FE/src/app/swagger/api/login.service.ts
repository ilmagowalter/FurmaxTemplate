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
/* tslint:disable:no-unused-variable member-ordering */

import { Inject, Injectable, Optional }                      from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,
         HttpResponse, HttpEvent }                           from '@angular/common/http';
import { CustomHttpUrlEncodingCodec }                        from '../encoder';

import { Observable }                                        from 'rxjs';

import { Autenticazione } from '../model/autenticazione';
import { ErroreGenerico } from '../model/erroreGenerico';
import { InformazioniAccesso } from '../model/informazioniAccesso';

import { BASE_PATH, COLLECTION_FORMATS }                     from '../variables';
import { Configuration }                                     from '../configuration';


@Injectable()
export class LoginService {

    protected basePath = 'http://localhost:8080/furmaxtemplate/rest';
    public defaultHeaders = new HttpHeaders();
    public configuration = new Configuration();

    constructor(protected httpClient: HttpClient, @Optional()@Inject(BASE_PATH) basePath: string, @Optional() configuration: Configuration) {
        if (basePath) {
            this.basePath = basePath;
        }
        if (configuration) {
            this.configuration = configuration;
            this.basePath = basePath || configuration.basePath || this.basePath;
        }
    }

    /**
     * @param consumes string[] mime-types
     * @return true: consumes contains 'multipart/form-data', false: otherwise
     */
    private canConsumeForm(consumes: string[]): boolean {
        const form = 'multipart/form-data';
        for (const consume of consumes) {
            if (form === consume) {
                return true;
            }
        }
        return false;
    }


    /**
     * Effettua il login
     * Valida le credenziali fornite ed effettua l&#39;accesso, ritornando la apiKey da utilizzare nelle altre chiamate
     * @param autenticazione 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public loginPost(autenticazione: Autenticazione, observe?: 'body', reportProgress?: boolean): Observable<InformazioniAccesso>;
    public loginPost(autenticazione: Autenticazione, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<InformazioniAccesso>>;
    public loginPost(autenticazione: Autenticazione, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<InformazioniAccesso>>;
    public loginPost(autenticazione: Autenticazione, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (autenticazione === null || autenticazione === undefined) {
            throw new Error('Required parameter autenticazione was null or undefined when calling loginPost.');
        }

        let headers = this.defaultHeaders;

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            'application/json'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
            'application/json'
        ];
        const httpContentTypeSelected: string | undefined = this.configuration.selectHeaderContentType(consumes);
        if (httpContentTypeSelected != undefined) {
            headers = headers.set('Content-Type', httpContentTypeSelected);
        }

        return this.httpClient.post<InformazioniAccesso>(`${this.basePath}/login`,
            autenticazione,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

}
