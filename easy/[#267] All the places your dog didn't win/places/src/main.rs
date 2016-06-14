use std::ops::Range;

fn other_places_range(place: u32, range: Range<u32>) -> String {
    range
    .filter(|&i| i != place)
    .map(|i| i.to_string() +
        match i % 10 {
            1 if i != 11 => "st",
            2 if i != 12 => "nd",
            3 if i != 13 => "rd",
            _ => "th" })
    .collect::<Vec<_>>()
    .join(", ")
}

fn other_places(place: u32) -> String {
    other_places_range(place, 0 .. 101)
}

fn main() {
    println!("{}", other_places(1));
}
