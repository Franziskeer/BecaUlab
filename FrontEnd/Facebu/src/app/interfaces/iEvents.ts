import { iUsers } from './iUsers';

export interface iEvents {
    id: number;
    name: string;
    description: string;
    eventDate: Date;
    creator: iUsers;
    state: string;
}