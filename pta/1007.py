def sort_fun(cur_obj):
    return (-cur_obj[0], cur_obj[1], cur_obj[2])


if __name__ == "__main__":
    n = int(input())
    nums_str = input()
    nums = nums_str.split(" ")
    nums = [int(num) for num in nums]
    i = 0
    res = []
    res.append([nums[0], 0, 0])
    i += 1

    while i < n:
        cur_sum = res[i - 1][0]
        cur_l = res[i - 1][1]
        cur_r = res[i - 1][2]
        if cur_sum > 0:
            res.append([cur_sum + nums[i], cur_l, cur_r + 1])
        else:
            res.append([nums[i], i, i])
        i += 1

    res.sort(key=sort_fun)
    nums_res = res[0]
    nums_res = [nums_res[0], nums[nums_res[1]], nums[nums_res[2]]]
    if nums_res[0] < 0:
        nums_res = [0, nums[0], nums[n - 1]]
    nums_res = [str(num) for num in nums_res]
    print(" ".join(nums_res))
