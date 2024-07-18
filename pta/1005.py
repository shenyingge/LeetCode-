def print_res(s: str):

    char_list = [
        'zero',
        'one',
        'two',
        'three',
        'four',
        'five',
        'six',
        'seven',
        'eight',
        'nine',
        'ten'
    ]
    s_list = [char_list[int(ch)] for ch in s]
    return ' '.join(s_list)


def calc(s: str):
    if s == '' or len(s) == 1:
        return s
    mid = len(s) // 2
    sl = calc(s[:mid])
    sr = calc(s[mid:])

    arr_l = [c for c in sl]
    arr_r = [c for c in sr]

    max_len = max(len(arr_l), len(arr_r))

    arr_l.reverse()
    arr_r.reverse()
    arr_l += ['0'] * (max_len - len(arr_l))
    arr_r += ['0'] * (max_len - len(arr_r))

    li, ri = 0, 0
    tag = 0
    res_num = []

    while li < len(arr_l) and ri < len(arr_r):
        cur_num = int(arr_l[li]) + int(arr_r[ri]) + tag
        if cur_num >= 10:
            cur_num -= 10;
            tag = 1
        else:
            tag = 0
        res_num.append(str(cur_num))
        li += 1
        ri += 1

    if tag == 1:
        res_num += ['1']
    res_num.reverse()
    res = ''.join(res_num)
    return res

if __name__ == "__main__":
    n = input()
    res = calc(n)
    print(print_res(res))
