(define (problem strips-ambulance-x-1)
   (:domain ambulance-strips)
   (:objects hospitalA hospitalB houseA houseB houseC patient1 patient2 patient3 bed1 bed2 bed3 bed4 bed5 bed6 Ambulance3 Ambulance1 Ambulance2)
   (:init (location hospitalA)
          (location hospitalB)
          (location houseA)
          (location houseB)
          (location houseC)
          (amb Ambulance1)
          (amb Ambulance3)
          (amb Ambulance2)
          (patient patient1)
          (patient patient2)
          (patient patient3)
         ; (at-ambu hospitalA Ambulance1)
         ; (at-ambu hospitalA Ambulance2)
          (at-ambu hospitalA Ambulance3)
          (connected hospitalA houseA)
          (connected houseA hospitalA)
          (connected houseA houseB)
          (connected houseB houseA)
          (connected hospitalA houseB)
          (connected houseB hospitalA)
          (connected houseB hospitalB)
          (connected hospitalB houseB)
          (connected houseC houseA)
          (connected houseA houseC)
          (free bed1 Ambulance1)
          (free bed2 Ambulance1)
          (free bed3 Ambulance2)
          (free bed4 Ambulance2)
          (free bed5 Ambulance3)
          (free bed6 Ambulance3)
          ;(free bed2)
         
          (at patient1 houseA)
          (at patient2 houseB)
          (at patient3 hospitalA)
          (bed bed1)
          (bed bed2)
          (bed bed3)
          (bed bed4)
          (bed bed5)
          (bed bed6)

          )
   (:goal (and (at patient1 hospitalA)
               (at patient2 hospitalA)
               (at patient3 houseC)
               ;(at-ambu houseB Ambulance1)
               )))
