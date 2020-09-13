import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { Column } from './models';
import { UuidService } from '../../services/uuid.service';


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss']
})
export class TableComponent implements OnInit, OnDestroy {
  @Input() public columns: Array<Column>;
  @Input() public rows: Array<any>;

  public currentPage = 1;
  public uuid: string = null;
  constructor(private uuidService: UuidService) {
    this.uuid = this.uuidService.generate();
  }

  ngOnInit() {
  }

  ngOnDestroy(): void {
    this.uuidService.remove(this.uuid);
  }

  pageChange(currentPage: number) {
    this.currentPage = currentPage;
  }
}
