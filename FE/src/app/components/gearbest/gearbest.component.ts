import { Component, OnInit } from '@angular/core';
import { Column } from '../../shared/components/table/models';
import { GearbestApi, ListCouponResponse, ListCoupon } from './models';
import { GearbestService } from '../../shared/services/gearbest.service';

@Component({
  selector: 'app-gearbest',
  templateUrl: './gearbest.component.html',
  styleUrls: ['./gearbest.component.scss']
})
export class GearbestComponent implements OnInit {

  public columns: Array<Column> = [
    { id: 'col1', label: 'col1', tooltip: 'col1', type: 'text' },
    { id: 'col2', label: 'col2', tooltip: 'col2', type: 'text' },
    { id: 'col3', label: 'col3', tooltip: 'col3', type: 'text' },
    { id: 'col4', label: 'col4', tooltip: 'col4', type: 'text' }
  ];

  // public rows: Array<any> = [
  //   { col1: '1', col2: 'Mark', col3: 'Otto', col4: '@ciao' },
  //   { col1: '1', col2: 'Mark', col3: 'Otto', col4: '@ciao' }
  // ];
  public rows: Array<ListCoupon> = [];

  public gearbestApis: Array<GearbestApi> = [
    { id: 'listcoupons', name: 'Lista coupons' }
  ];

  public gearbestApiSelected: string;

  public risposta: ListCouponResponse;
  constructor(private gearbestService: GearbestService) { }

  ngOnInit() {
  }

  searchListCoupons() {
    this.gearbestService.listCoupons().subscribe(
      (risposta: ListCouponResponse) => {
        this.columns = this.getColumnsFromObject(risposta.data.items[0]);
        this.rows = risposta.data.items;
      }
    );
  }

  getColumnsFromObject(object: any): Array<Column> {
    const columns: Array<Column> = [];
    const cols: Array<string> = Object.keys(object);
    cols.forEach(
      (col: string, index: number) => {
        const column: Column = {
          id: index.toString(),
          label: col,
          tooltip: col,
          type: col
        };
        columns.push(column);
      }
    );
    return columns;
  }
}
