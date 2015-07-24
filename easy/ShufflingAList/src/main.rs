use std::io;
use std::cmp::Ordering;
use std::env;

fn main()
{
	let args: Vec<_> = env::args().collect();

	if args.len() > 1
	{
		println!("The first argument is {}", args[1])
	}
}//End of main