(define (problem gripper-x-10)
(:domain ambulance-strips)
(:objects hospitalA hospitalB house1 house2 house3 house4 house5 house6 house7 house8 house9 house10 patient1 patient2 patient3 patient4 patient5 patient6 patient7 patient8 patient9 patient10 bed1 bed2 )
(:init (location hospitalA)
(location hospitalB)
(location house1)
(location house2)
(location house3)
(location house4)
(location house5)
(location house6)
(location house7)
(location house8)
(location house9)
(location house10)
(patient patient1)
(patient patient2)
(patient patient3)
(patient patient4)
(patient patient5)
(patient patient6)
(patient patient7)
(patient patient8)
(patient patient9)
(patient patient10)
(at-ambu hospitalA)
(connected hospitalA house1)
(connected house1 hospitalA)
(connected hospitalA house2)
(connected house2 hospitalA)
(connected hospitalA house3)
(connected house3 hospitalA)
(connected hospitalA house4)
(connected house4 hospitalA)
(connected hospitalA house5)
(connected house5 hospitalA)
(connected hospitalA house6)
(connected house6 hospitalA)
(connected hospitalA house7)
(connected house7 hospitalA)
(connected hospitalA house8)
(connected house8 hospitalA)
(connected hospitalA house9)
(connected house9 hospitalA)
(connected hospitalA house10)
(connected house10 hospitalA)
(free bed1)(free bed2)
(at patient1 house1)
(at patient2 house2)
(at patient3 house3)
(at patient4 house4)
(at patient5 house5)
(at patient6 house6)
(at patient7 house7)
(at patient8 house8)
(at patient9 house9)
(at patient10 house10)
(ambulance bed1)
(ambulance bed2)
)

(:goal
(and
(at patient1 hospitalA)
(at patient2 hospitalA)
(at patient3 hospitalA)
(at patient4 hospitalA)
(at patient5 hospitalA)
(at patient6 hospitalA)
(at patient7 hospitalA)
(at patient8 hospitalA)
(at patient9 hospitalA)
(at patient10 hospitalA)
)
)
)
