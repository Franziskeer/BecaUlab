import { iUsers } from '../interfaces/iUsers';
import { Events } from './events';

export class Users implements iUsers {
    id: number;
    name: string;
    surname: string;
	birthDate: Date;
    startDate: Date;
    user: string;
    pass: string;
    score: number;
    // reactions: Reactions[];
    // assitances: Assistances[];
    // createdMessages: Messages[];
    createdEvents: Events[];
    // following: Relationships[];
    // followers: Relationships[];

    constructor() {
        
    }
}
