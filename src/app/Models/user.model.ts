import { Address } from './address.model';
export class User {
    id?: number;
    firstName: string;
    lastName: string;
    age: number;
    address: Address;
}