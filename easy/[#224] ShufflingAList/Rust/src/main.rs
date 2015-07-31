extern crate rand;

use std::io;
use std::cmp::Ordering;
use std::env;
use rand::Rng;

fn main()
{
	let mut result = shuffle(env::args().collect());

	for y in result.iter() 
	{
    	println!("{}", y);
	}
}//End of main

fn shuffle<T>(mut args: Vec<T>) -> Vec<T>
{ 
	let mut temp = Vec::with_capacity((args.capacity()));

	while args.len() > 1 
	{
		let mut n = rand::thread_rng().gen_range(1, args.len());
		temp.push(args.swap_remove(n));
	}

	return temp;
}//End of shuffle function