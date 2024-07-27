from decimal import Decimal


class PloyItem:
    def __init__(self, ex, co):
        self.ex = int(ex)
        self.co = Decimal(co)

    @classmethod
    def multi(cls, i1, i2):
        ex = i1.ex + i2.ex
        co = i1.co * i2.co
        return PloyItem(ex, co)

    def __str__(self):
        print(self.ex, self.co)

    def __repr__(self):
        return f"{self.ex} {self.co}"


class Ploy:
    def __init__(self, item_list: list[PloyItem]):
        self.items = {}

        for item in item_list:
            self.items[item.ex] = item.co

    def plus(self, item):
        if item.ex in self.items:
            self.items[item.ex] += item.co
        else:
            self.items[item.ex] = item.co

    def __str__(self):
        _keys = list(self.items.keys())
        _keys = [k for k in _keys if self.items[k] != 0]
        _keys.sort(reverse=True)
        pstr = []
        for k in _keys:
            pstr.append(f"{k} {round(self.items[k], 1)}")

        n = f"{len(_keys)}"
        res = " ".join(pstr)
        if n == "0":
            return n
        return " ".join([n, res])


def calc(p1: Ploy, p2: Ploy):
    p1_list = [PloyItem(k, p1.items[k]) for k in p1.items]
    p2_list = [PloyItem(k, p2.items[k]) for k in p2.items]
    res = Ploy([])

    for item_p1 in p1_list:
        for item_p2 in p2_list:
            item = PloyItem.multi(item_p1, item_p2)
            res.plus(item)
    return res


if __name__ == "__main__":
    p1 = input()
    p2 = input()

    p1_list = p1.split(" ")[1:]
    p2_list = p2.split(" ")[1:]

    p1_list = [float(i) for i in p1_list]
    p2_list = [float(i) for i in p2_list]

    _p1_list = []
    _p2_list = []
    for i in range(0, len(p1_list), 2):
        item = PloyItem(p1_list[i], p1_list[i + 1])
        _p1_list.append(item)

    for i in range(0, len(p2_list), 2):
        item = PloyItem(p2_list[i], p2_list[i + 1])
        _p2_list.append(item)

    _p1 = Ploy(_p1_list)
    _p2 = Ploy(_p2_list)

    print(calc(_p1, _p2))
