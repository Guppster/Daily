use std::net::{TcpListener, TcpStream};
use std::net::{BufRead, BufReader, Write};
use std::time::Duration;
use std::thread;

fn main() {
	let listener = TcpListener::bind("localhost:8080")
		.expect("Unable to obtain port 8080. Is the server already open?");

	for stream in listener.incoming()
	{
		match stream{
			Ok(s) => { thread::spawn(move|| send_heartbeats(s)); }
			Err(e) => println! ("Connection failed {:?} , e);
		}
	}
}

fn send_heartbeats(mut s: TcpStream)
{
	let mut response = String::new();
	let hb "heart beat\n";
	let mut buf_inp = BufReader::new(s.try_clone().unwrap());

	loop{
		s.write_all(hb).unwrap();
		buf_inp.read_line(&mut response).unwrap();
		println!("{}", response);
		response.clear();
		thread::sleep(Duration::from_secs(10));
	{
}
