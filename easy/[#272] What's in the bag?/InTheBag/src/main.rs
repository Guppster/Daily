#[macro_use] extern crate maplit;

fn main() {
    let mut m = hashmap!{'A' => 9, 'B' => 2, 'C' => 2, 'D' => 4, 'E' => 12, 'F' => 2, 'G' => 3, 'H' => 2,
                    'I' => 9, 'J' => 1, 'K' => 1, 'L' => 4, 'M' => 2, 'N' => 6, 'O' => 8, 'P' => 2,
                    'Q' => 1, 'R' => 6, 'S' => 4, 'T' => 6, 'U' => 4, 'V' => 2, 'W' => 2, 'X' => 1,
                    'Y' => 2, 'Z' => 1,  '_' => 2};
    let arg = std::env::args().nth(1).expect("You must provide which letters have been drawn");
    for c in arg.chars(){
        let counter = m.get_mut(&c).expect(&format!("'{}' is not a valid character",c)); *counter-=1;
        if *counter<0{
            println!("Invalid Input. More {}'s have been taken from the bag than possible.",c);
            return;
        }
    }
    let mut m2 = std::collections::BTreeMap::new();
    for (&key,&value) in m.iter(){
        m2.entry(value).or_insert(Vec::new()).push(key.to_string());
    }
    for (key,value) in m2.iter_mut().rev(){
        value.sort();
        println!("{}: {}",key,value.join(", "));
    }
}
