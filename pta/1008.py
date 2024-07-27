if __name__ == "__main__":
    input_str = input()
    input_list = input_str.split(" ")
    input_list = [int(i) for i in input_list]
    input_list = input_list[1:]
    res = 0
    last_floor = 0
    for i in input_list:
        if i > last_floor:
            res += 6 * (i - last_floor)
        else:
            res += 4 * (last_floor - i)
        res += 5
        last_floor = i
    print(res)
