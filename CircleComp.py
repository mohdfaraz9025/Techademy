import math


class CircleComp:
    def __init__(self, radius):
        self.area = None
        self.diameter = None
        self.circumference = None
        self.radius = radius

    def calculate(self):
        self.diameter = self.radius * 2.0
        self.circumference = 2 * math.pi * self.radius
        self.area = math.pi * (self.radius ** 2)

    def display(self):
        print("Diameter:", self.diameter)
        print("Circumference:", self.circumference)
        print("Area:", self.area)

radius = float(input("Enter the radius of the circle: "))
circle = CircleComp(radius)
circle.calculate()
circle.display()
