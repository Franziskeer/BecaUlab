import { iEvents } from '../interfaces/iEvents';
import { Users } from '../model/users';

export class Events implements iEvents {
    id: number;
    name: string;
    description: string;
    eventDate: Date;
    creator: Users;
    state: string;
}

