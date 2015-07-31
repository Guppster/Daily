import sys
 
epsilon = 1e-9
 
def balance_point(wts):
    tot_wt = sum(wts)
    first_moment = sum(i*w for i, w in enumerate(wts))
    print (tot_wt)
    print (first_moment)
    mean = first_moment / tot_wt
    print(mean)
    m = round(mean)
    print(m)
    if abs(mean - m) < epsilon:
        return m, sum(i*w for i, w in enumerate(wts[m:]))
    else:
        return None, None
 
def iofn(s):
    wts = [ord(c) - 64 for c in s]
    x, y = balance_point(wts)
    if x is None:
        return "{} DOES NOT BALANCE".format(s)
    else:
        return "{} {} {} - {}".format(s[:x], s[x], s[x+1:], y)
 
print(iofn(sys.stdin.readline().strip()))
