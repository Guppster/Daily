use std::net::TcpStream;
use std::io::{Write, BufRead, BufReader};


fn main() {
	let server = std::env::args().skip(1).next()
		.expect("Pass a server address as an argument");
	
	let s = TcpStream::connect(&*server).expect("Could not reach server.");
	handle_heartbeats(s);
}

fn handle_heartbeats(mut s: TcpStream)
{
	let mut hb = String::new();
	let mut read = BufReader::new(s.try_clone().unwrap());

	loop
	{
		read.read_line(&mut hb).unwrap();
		s.write_all(hb.as_bytes()).unwrap();
		println!("{}", hb);
		hb.clear();
	}
}
