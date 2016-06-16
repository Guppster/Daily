use std::io::prelude::*;
use std::collections::{HashMap, HashSet};
use std::iter::FromIterator;

struct Reindenter<'a> 
{
		    indent_str: String,
		    keywords: HashMap<&'a str, &'a str>,
		    terminators: HashSet<&'a str>
}

impl<'a> Reindenter<'a> 
{
	fn reindent(&self, l: &mut Iterator<Item=std::io::Result<String>>, indent: String, cur: &str) -> Option<String> 
	{
		loop 
		{
			if let Some(Ok(s)) = l.next() 
			{
				let w = s.trim().split_whitespace().next().unwrap();

				if w == cur 
				{
					return Some(s.clone());
				}

				if self.terminators.contains(w) 
				{
					println!("Error: found {}, expecting {}", w, cur);
				}

				println!("{}{}", &indent, s.trim());

				if let Some(k) = self.keywords.get(w) 
				{
					if let Some(r) = self.reindent(l, indent.clone() + &self.indent_str, k) 
					{
						println!("{}{}", &indent, r.trim());
					}
				}
			} else 
			{
				if cur != "" 
				{
					println!("Error: unmatched {} at EOF", cur);
				}

				return None;
			}
		}
	}
}

fn main() {
	let filename = std::env::args().nth(1).unwrap_or(String::from("269_Basic.txt"));
	let f = std::fs::File::open(filename).unwrap();
	let r = std::io::BufReader::new(f);
	let mut l = r.lines();
	let _ = l.next(); // Ignore number of lines, we don't care

	let indent_str = l.next().unwrap().unwrap();
	let keywords: HashMap<&str, &str> = HashMap::from_iter(vec![("IF", "ENDIF"), ("FOR", "NEXT")]);
	let terminators = keywords.values().map(|&v| v).collect::<HashSet<_>>();

	let reindenter = Reindenter { indent_str: indent_str, keywords: keywords, terminators: terminators };
	reindenter.reindent(&mut l, "".into(), "");
}
