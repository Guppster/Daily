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
