(define (domain ambulance-strips)
   (:predicates (location ?l)
		(patient ?p)
		(bed ?a)
		(amb ?m)
		(at-ambu ?l ?m)
		(at ?b ?l)
		(free ?b ?m)
		(connected ?l ?l )
		(carry ?o ?a ?m))

  (:action move
       :parameters  (?m1 ?from ?to )
       :precondition (and (amb ?m1) (location ?from) (location ?to) (at-ambu ?from ?m1) (connected ?from  ?to))
       :effect (and  (at-ambu ?to ?m1)
		     (not (at-ambu ?from ?m1))))



   (:action pick
       :parameters (?obj ?location ?m2 ?bed )
       :precondition  (and (amb ?m2) (patient ?obj) (location ?location) (bed ?bed)
			    (at ?obj ?location) (at-ambu ?location ?m2) (free ?bed ?m2) )
       :effect (and (carry ?obj ?bed ?m2)
		    (not (at ?obj ?location)) 
		    (not (free ?bed ?m2))))


   (:action drop
       :parameters  (?obj  ?location ?m3 ?bed)
       :precondition  (and  (amb ?m3)(patient ?obj) (location ?location) (bed ?bed)
			    (carry ?obj ?bed ?m3) (at-ambu ?location ?m3) )
       :effect (and (at ?obj ?location)
		    (free ?bed ?m3)
		    (not (carry ?obj ?bed ?m3)
		    )
		    )))

