import { Component, OnInit, Input, EventEmitter, Output, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css']
})
export class PaginationComponent implements OnInit {
  @Input() size: number;
  @Input() numberOfElements: number;
  @Input() totalPages: number;

  @Output() currentPage = new EventEmitter<number>();
  @Output() sizeModified = new EventEmitter<number>();

  pages: number[] = [];
  linkActive: number = 0;

  constructor() { }

  ngOnChanges(changes: SimpleChanges) {
    this.pages = [];
    for (let index = 0; index < this.totalPages; index++) {
      this.pages[index] = index+1;
    }
  }

  ngOnInit() {
    for (let index = 0; index < this.totalPages; index++) {
      this.pages[index] = index+1;
    }
  }

  disabledPrevious() {
    return this.linkActive === 0;
  }

  disabledNext() {
    let linkActiveSub = this.linkActive;
    linkActiveSub++;
    return linkActiveSub === this.totalPages;
  }
  
  changePage(page: number) {
    this.linkActive = page;
    this.currentPage.emit(this.linkActive);
  }

  onEnter() {
    this.sizeModified.emit(this.size);
  }

  nextMethod() {
    this.linkActive++;
    this.currentPage.emit(this.linkActive);
  }

  previousMethod() {
    this.linkActive--;
    this.currentPage.emit(this.linkActive);
  }

}
