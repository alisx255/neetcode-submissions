class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        c = [list(pair) for pair in zip(position, speed)]
        combined = sorted(c)
        fleets = 0
        while(combined):
            if len(combined) == 1:
                fleets += 1
                return fleets
            car1 = combined.pop()
            d1 = target - car1[0]
            t1 = d1 / car1[1]
            car2 = combined[-1]
            d2 = target - car2[0]
            t2 = d2 / car2[1]
            if t1 < t2:
                fleets += 1
            else: 
                combined[-1][0] = car1[0]
                combined[-1][1] = car1[1]
        return fleets



