use std::*;

fn main() 
{
	let mut data: Vec<_> = env::args().collect();

	for s in data.iter()
	{
		let mass = getMass(data);
		let balanceIndex = getBalanceIndex(mass);

		if(balanceIndex == 0)
		{
			//println!("{} DOES NOT BALANCE", s);
		}

	}
}//End of Main method

fn getBalanceIndex(mass: Vec<i32>) -> i32
{
	let epsilon = 1e-9;
	//let total = mass.iter().sum();

}//End of getBalanceIndex function

fn getBalanceSum(mass: Vec<i32>) -> i32
{

}//End of getBalanceSum function

fn getMass(data: String) -> Vec<i32>
{

}//End of getMass function

