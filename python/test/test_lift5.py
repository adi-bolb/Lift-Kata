from nimoy.specification import Specification

from lift5 import GreedyLiftCommandHandler, Building, Lift


class LiftTest(Specification):

    def test_lift_delivers_to_requested_floor_in_a_greedy_way(self):
        with given:
            commandHandler = GreedyLiftCommandHandler()
            building = Building(-2, 6)
            lift = Lift(building, commandHandler)
            lift.turnOn()
            lift.go(3)
            lift.go(4)
        with when:
            lift.operate()
        with then:
            lift.getCurrentFloor() == 3
        with when:
            lift.operate()
        with then:
            lift.getCurrentFloor() == 4
