extern crate rand;

use std::io;
use std::cmp::Ordering;
use std::env;
use rand::Rng;

fn main()
{
	let mut args: Vec<_> = env::args().collect();
	let mut result: Vec<_> = Vec::with_capacity(args.capacity());

	if args.len() > 1
	{
		println!("There are(is) {} argument(s)", args.len() - 1)
	}

	while args.len() > 1 
	{
		let mut n = rand::thread_rng().gen_range(1, args.len());
		result.push(args.swap_remove(n));
	}

	for y in result.iter() 
	{
    	println!("{}", y);
	}
}//End of main