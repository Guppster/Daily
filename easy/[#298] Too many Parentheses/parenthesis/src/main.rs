#[cfg(test)]
mod tests 
{
    use super::{bracket_map, solve};

#[test]
    fn bracket_map_test() 
    {
        assert_eq!(bracket_map("(ab(c))"), vec![(3usize, 5usize), (0usize, 6usize)]);
    }

#[test]
    fn solve_test() 
    {
        assert_eq!(&solve("()"), "NULL");
        assert_eq!(&solve("()(abc())"), "(abc)");
        assert_eq!(&solve("((a((bc)(de)))f)"), "((a((bc)(de)))f)");
    }
}

pub fn solve(input: &str) -> String 
{
    let brackets = bracket_map(&input);

    let mut filter_map = Vec::new();

    for (first, last) in brackets.clone() 
    {
        if brackets.contains(&(first + 1, last - 1)) || last - first == 1
        {
            filter_map.push(first);
            filter_map.push(last);
        }
    }

    let mut solution = String::new();

    for (i, ch) in input.chars().enumerate() 
    {
        if !filter_map.contains(&i)
        {
            solution.push(ch);
        }
    }

    if solution.len() != 0 
    {
        solution
    } 
    else 
    {
        "NULL".to_string()
    }
}
