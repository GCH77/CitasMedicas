import { Agenda } from './Agenda'

export class Pagination {
  content: Agenda[];
  pageable: {
    sort: {
        sorted: boolean,
        unsorted: boolean,
        empty: boolean
    },
    offset: number,
    pageNumber: number,
    pageSize: number,
    paged: boolean,
    unpaged: boolean
  };
  last: boolean;
  totalPages: number;
  totalElements: number;
  size: number;
  number: number;
  sort: {
      sorted: boolean,
      unsorted: boolean,
      empty: boolean
  };
  numberOfElements: number;
  first: boolean;
  empty: boolean;
}