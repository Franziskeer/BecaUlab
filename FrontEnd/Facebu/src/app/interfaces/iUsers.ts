import { Events } from '../model/events';

export interface iUsers {
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
}
