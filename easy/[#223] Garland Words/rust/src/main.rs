#![feature(slice_splits)]
struct Garland<'w> 
{
    word: &'w str,
    length: usize
}

fn main() 
{
    for word in std::env::args().skip(1)
    {
    	match garland(&word)
    	{
    		Some(garland) => println!("{}: {}", garland.word, garland.length),
    		None => println!("{} is not a garland word", word)
    	}
    }

}//End of main method

fn garland(s: &str) -> Option<Garland>
{
	let characters: Vec<_> = s.chars().collect();
	let mut a = drop_tail(&characters);
	let mut b = drop_head(&characters);

	loop 
	{
		if a.len() == 0 { return None; }

		if a == b
		{
			return Some(Garland{
				word: s,
				length: a.len()
			})
		}

		a = drop_tail(a);
		b = drop_head(b);
	}
}

#[inline]
fn drop_head<T>(s: &[T]) -> &[T]
{
	s.split_first().map(|(_, tail)| tail).unwrap()
}

#[inline]
fn drop_tail<T>(s: &[T]) -> &[T]
{
	s.split_last().map(|(_, lead)| lead).unwrap()
}
