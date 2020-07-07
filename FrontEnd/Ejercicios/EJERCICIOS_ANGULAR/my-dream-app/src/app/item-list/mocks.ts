import { Item } from '../item.model';

export const ITEMS: Item[] = [{
    'id': 1,
    'name': 'Item name',
    'description': 'These item is the best one',
    'stock': 5,
    'price': 14.99,
    'image': '../../assets/product.jpg',
    'selected': false,
    'quantity': 0
  },
  {
    'id': 2,
    'name': 'Another Item name',
    'description': 'These item is the smallest',
    'stock': 7,
    'price': 5,
    'image': '../../assets/product.jpg',
    'selected': true,
    'quantity': 0
  },
  {
    'id': 3,
    'name': 'A cheap Item',
    'description': 'The cheapest item',
    'stock': 0,
    'price': 2.99,
    'image': '../../assets/product.jpg',
    'selected': false,
    'quantity': 0
  }
];
