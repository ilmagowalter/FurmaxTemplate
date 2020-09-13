import { Md5 } from 'ts-md5/dist/md5';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { isNullOrUndefined } from 'util';

const GB_API_PATH = 'https://affiliate.gearbest.com/api/';
const GB_API_KEY = '1245110';
const GB_API_SECRET = 'vhPOdCq4b1R';
const GB_LKID = '10000320';
const GB_LANGUAGE_REQUEST = 'it';

@Injectable()
export class GearbestService {

  constructor(protected httpClient: HttpClient) { }

  listCoupons(categoria?: string, pagina?: number): Observable<any> {
    let queryParameters = new HttpParams();
    queryParameters = queryParameters.set('api_key', GB_API_KEY);
    queryParameters = queryParameters.set('time', new Date().getTime().toString());
    queryParameters = queryParameters.set('lkid', GB_LKID);
    queryParameters = queryParameters.set('language', GB_LANGUAGE_REQUEST);
    if (!isNullOrUndefined(categoria)) {
      queryParameters = queryParameters.set('category', categoria);
    }
    if (!isNullOrUndefined(pagina)) {
      queryParameters = queryParameters.set('page', pagina.toString());
    }
    const sign = this.getSignature(queryParameters);
    queryParameters = queryParameters.set('sign', sign);

    return this.httpClient.get<any>(`${GB_API_PATH}coupon/list-coupons?`,
      {
        params: queryParameters
      }
    );
  }

  listPromotionProduct(categoria?: string, pagina?: number): Observable<any> {
    let queryParameters = new HttpParams();
    queryParameters = queryParameters.set('api_key', GB_API_KEY);
    queryParameters = queryParameters.set('time', new Date().getTime().toString());
    queryParameters = queryParameters.set('lkid', GB_LKID);
    queryParameters = queryParameters.set('currency', 'EUR');
    // queryParameters = queryParameters.set('country_website', GB_LANGUAGE_REQUEST);
    if (!isNullOrUndefined(categoria)) {
      queryParameters = queryParameters.set('category', categoria);
    }
    if (!isNullOrUndefined(pagina)) {
      queryParameters = queryParameters.set('page', pagina.toString());
    }
    const sign = this.getSignature(queryParameters);
    queryParameters = queryParameters.set('sign', sign);

    return this.httpClient.get<any>(`${GB_API_PATH}products/list-promotion-products?`,
      {
        params: queryParameters
      }
    );
  }

  private getSignature(queryParameters: HttpParams): string {
    let sign = '';
    queryParameters.keys().sort().forEach(
      (key: string) => {
        sign += key + queryParameters.get(key);
      }
    );
    sign = GB_API_SECRET + sign + GB_API_SECRET;
    console.log('sign', sign);
    return Md5.hashStr(sign).toString().toUpperCase();
  }
}
