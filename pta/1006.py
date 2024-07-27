class Sign:
    def __init__(self, _id, start, end):
        self.id = _id
        self.start = start
        self.end = end


if __name__ == "__main__":
    n = input()
    res = []

    for i in range(0, int(n)):
        input_str = input()
        _id, start, end = input_str.split(" ")

        sign = Sign(_id, start, end)
        res.append(sign)

    res = sorted(res, key=lambda s: s.start, reverse=False)

    earliest = res[0].id

    res = sorted(res, key=lambda s: s.end, reverse=True)

    latest = res[0].id

    print(f"{earliest} {latest}")
