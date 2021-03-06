use std::io::prelude::*;
use std::io::{Lines,BufReader};
use std::fs::File;
use std::path::Path;
use std::str::FromStr;
use std::ops::Div;

fn squared(x: u64) -> u64 {
    x*x
}

/// Calculate ring of specified index
fn ring_of_index(index: u64) -> u64 {
    (index as f64).sqrt().ceil().div(2.0).floor() as u64
}

/// Calculate index of first cell in specified ring
fn ring_start(ring: u64) -> u64 {
    match ring {
        0 => 1,
        _ => 1 + squared(ring*2 - 1),
    }
}

/// Convert an index to a coordinate (x, y) for the specified grid size
fn index_to_coord(index: u64, size: u64) -> (u64, u64) {
    let center = (size + 1) / 2;

    let ring = ring_of_index(index);

    if ring == 0 {
        return (center, center);
    }

    let side_len = ring * 2;
    let ring_index = index - ring_start(ring);
    let side = ring_index / side_len;
    let side_index = 1 + ring_index % side_len; // add 1 here to avoid adding in each clause

    let (x, y) = match side {
        0 => (center + ring, center + ring - side_index),
        1 => (center + ring - side_index, center - ring),
        2 => (center - ring, center - ring + side_index),
        3 => (center - ring + side_index, center + ring),
        _ => unreachable!(),
    };

    (x, y)
}

/// Convert a coordinate to an index for the specified grid size
fn coord_to_index(x: u64, y: u64, size: u64) -> u64 {
    let center = (size + 1) / 2;
    let dx = (x as i64) - (center as i64);
    let dy = (y as i64) - (center as i64);
    let ring = std::cmp::max(dx.abs(), dy.abs());

    if ring == 0 {
        return 1;
    }

    let side_len = ring * 2;

    let mut side;
    let mut side_index;

    if dx.abs() == dy.abs() {
        // at a corner, i.e. end of a side
        // index with ring is a multiple of side len - 1
        side_index = side_len - 1;
        side = if dx > 0 {
            if dy > 0 { 3 } else { 0 }
        } else {
            if dy > 0 { 2 } else { 1 }
        };
    }
    else {
        if dx.abs() == ring {
            if dx > 0 {
                side = 0;
                side_index = ring - 1 - dy;
            } else {
                side = 2;
                side_index = ring - 1 + dy;
            }
        } else {
            if dy > 0 {
                side = 3;
                side_index = ring - 1 + dx;
            } else {
                side = 1;
                side_index = ring - 1 - dx;
            }
        }
    }

    ring_start(ring as u64) + (side_index + side * side_len) as u64
}

fn parse_value(input: &str) -> u64 {
    u64::from_str(input).ok().expect("All input values must be integers!")
}

fn parse_input(line1: &str, line2: &str) {
    let size = parse_value(line1);
    let mut values = line2.split_whitespace();

    let v1 = parse_value(values.next().expect("Must specify at least 1 value"));

    let v2 = values.next();

    if v2.is_some() {
        println!("{:?}", coord_to_index(v1, parse_value(v2.unwrap()), size));
    } else {
        println!("{:?}", index_to_coord(v1, size));
    }
}

fn parse_lines(input: &mut std::io::Lines<std::io::BufReader<File>>) {
    parse_input(
        &input.next().expect("size not specified!").unwrap(),
        &input.next().expect("input value(s) not specified!").unwrap());
}

fn lines_from_file<P>(filename: &P) -> std::io::Lines<std::io::BufReader<File>>
    where P: AsRef<Path> {

    let file = File::open(filename).ok().expect("Failed to specified file");
    std::io::BufReader::new(file).lines()
}

fn main() {
    let args: Vec<_> = std::env::args().collect();
    if args.len() > 1 {
        parse_lines(&mut lines_from_file(&args[1]));
    }
    else {
        let stdin = std::io::stdin();
        println!("Input grid size: ");
        let line1 = stdin.lock().lines().next().unwrap().unwrap();
        println!("Input value(s): ");
        let line2 = stdin.lock().lines().next().unwrap().unwrap();
        println!("Answer:");
        parse_input(&line1, &line2);
    }
}


#[test]
fn test_ring_of_index() {
    assert_eq!(0, ring_of_index(1));
    assert_eq!(1, ring_of_index(2));
    assert_eq!(1, ring_of_index(8));
    assert_eq!(1, ring_of_index(9));
    assert_eq!(2, ring_of_index(10));
    assert_eq!(2, ring_of_index(24));
    assert_eq!(2, ring_of_index(25));
    assert_eq!(3, ring_of_index(26));
}

#[test]
fn test_index_to_coord() {
    assert_eq!((2, 3), index_to_coord(8, 3));
    assert_eq!((3, 3), index_to_coord(1, 5));
    assert_eq!((10, 9), index_to_coord(50, 11));
    assert_eq!((512353188, 512346213), index_to_coord(557614022, 1024716039));

}

#[test]
fn test_coord_to_index() {
    assert_eq!(1, coord_to_index(2, 2, 3));
    assert_eq!(2, coord_to_index(3, 2, 3));
    assert_eq!(3, coord_to_index(3, 1, 3));
    assert_eq!(4, coord_to_index(2, 1, 3));
    assert_eq!(5, coord_to_index(1, 1, 3));
    assert_eq!(6, coord_to_index(1, 2, 3));
    assert_eq!(7, coord_to_index(1, 3, 3));
    assert_eq!(8, coord_to_index(2, 3, 3));
    assert_eq!(9, coord_to_index(3, 3, 3));
    assert_eq!(1, coord_to_index(3, 3, 5));
    assert_eq!(37, coord_to_index(1, 1, 7));
    assert_eq!(50, coord_to_index(10, 9, 11));
    assert_eq!(54790653381545607, coord_to_index(11777272, 289722, 234653477));
}