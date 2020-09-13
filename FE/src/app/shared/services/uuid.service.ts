import { Injectable } from '@angular/core';
import * as uuid from 'uuid';

@Injectable()
export class UuidService {

  public uuids: string[] = [];

  constructor() {}

  public generate(): string {
    let isUnique = false;
    let tempId = '';
    while (!isUnique) {
      tempId = this.generator();
      if (!this.idExists(tempId)) {
        isUnique = true;
        this.uuids.push(tempId);
      }
    }
    return tempId;
  }

  public remove(id: string): void {
    const index = this.uuids.indexOf(id);
    this.uuids.splice(index, 1);
  }

  private generator(): string {
    const isString = `${uuid.v4()}`;

    return isString;
  }

  private idExists(id: string): boolean {
    return this.uuids.includes(id);
  }

}
