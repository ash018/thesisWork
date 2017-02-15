/*
	Copyright
	Author: S. M. AKASH
	Bangladesh University of Engineering & Technology
	This is a generator file for Ambulance Domain
	All rights reserved. Use of this software is permitted for 
    non-commercial research purposes, and it may be copied only 
    for that use.
*/

#include <stdlib.h>
#include <stdio.h>
#include <sys/timeb.h>

typedef unsigned char Bool;
#define TRUE 1
#define FALSE 0

void usage( void );
Bool process_command_line( int argc, char *argv[] );

int objPatient;
int ambulanceNum;
int bedSize;

int main( int argc, char *argv[])
{

	struct timeb tp;
  	ftime( &tp );
  	srandom( tp.millitm );
  	
  	int i;
  	objPatient = -1;
  	
  	if ( argc == 1 || ( argc == 2 && *++argv[0] == '?' ) ) {
    usage();
    exit( 1 );
  	}
  	if ( !process_command_line( argc, argv ) ) {
    usage();
    exit( 1 );
  }
  
  printf("(define (problem gripper-x-%d)", objPatient);
  printf("\n(:domain ambulance-strips)");
  printf("\n(:objects ");
  printf("hospitalA hospitalB ");
  for ( i = 0; i < objPatient; i++ )
  	printf("house%d ",i+1);
  for ( i = 0; i < objPatient; i++ )
  	printf("patient%d ",i+1);
  //printf("bed1 bed2 ");
  for(i=0; i<ambulanceNum*bedSize; i++)
  	printf("bed%d ",i+1);
  for( i=0; i< ambulanceNum;i++)
  	printf("ambulance%d ",i+1);
  printf(")");
  
  
  printf("\n(:init ");
  printf("(location hospitalA)\n(location hospitalB)\n");
  
  for(i=0; i<objPatient; i++)
  	printf("(location house%d)\n",i+1);
  	
  for(i=0; i<ambulanceNum;i++)
  	printf("(amb ambulance%d)\n",i+1);
  
  for(i=0; i<objPatient; i++)
 	 printf("(patient patient%d)\n",i+1);
 	 
  for(i=0; i<ambulanceNum;i++) 
   printf("(at-ambu hospitalA ambulance%d)\n",i+1);
  
  for(i=0; i<objPatient; i++){
  	printf("(connected hospitalA house%d)\n",i+1);
  	printf("(connected house%d hospitalA)\n",i+1);
  }
  
  /*
  printf("(free bed1)");
  printf("(free bed2)\n");
  */
  int j = 0;
  
   for(i=0; i<ambulanceNum;i++)
   {
   	
   //	printf("(free bed%d Ambulance2%d)\n",j,i+1);
   //	printf("(free bed%d Ambulance2%d)\n",j+1,i+1);
   /*
   		printf("(free bed%d ",j+1);
   		printf("ambulance%d)\n",i+1);
   		printf("(free bed%d ",j+2);
   		printf("ambulance%d)\n",i+1);
   		printf("(free bed%d ",j+3);
   		printf("ambulance%d)\n",i+1);
   		printf("(free bed%d ",j+4);
   		printf("ambulance%d)\n",i+1);
   		printf("(free bed%d ",j+5);
   		printf("ambulance%d)\n",i+1);
   		
   	*/	
   		int k = 1;
   		while(k<=bedSize)
   		{
   			printf("(free bed%d ",j+k);
   			printf("ambulance%d)\n",i+1);
   			k++;
   		}
   		
   		j+=bedSize;
   		
   }
  
  int var;
  
  for(i=0; i<objPatient; i++){
    var = i+1;
  	printf("(at patient%d ",var);
  	printf("house%d)\n",var);
  }
  
  //printf("(bed bed1)\n(bed bed2)\n)");
  
  for(i=0; i<ambulanceNum*bedSize; i++)
  	printf("(bed bed%d) \n",i+1);
  
  printf(")\n");
  printf("\n\n(:goal");
  printf("\n(and");
  for ( i = 0; i < objPatient; i++ ) {
  	printf("\n(at patient%d hospitalA)", i + 1);
  }
  
  
  
  printf("\n)");
  printf("\n)");
  printf("\n)");
  
  
  exit( 0 );
    
}





void usage( void )

{

  printf("\nusage:\n");

  printf("\nOPTIONS   DESCRIPTIONS\n\n");
  printf("-n <num>    number of patients (minimum 1)\n\n");

}

Bool process_command_line( int argc, char *argv[] )

{

  char option;

  while ( --argc && ++argv ) {
    if ( *argv[0] != '-' || strlen(*argv) != 2 ) {
     return FALSE;
    }
    option = *++argv[0];
    switch ( option ) {
    default:
      if ( --argc && ++argv ) {
	switch ( option ) {
	case 'n':
	  sscanf( *argv, "%d", &objPatient );
	  break;
	case 'a':
	 sscanf(*argv,"%d",&ambulanceNum);
	 break; 
	case 'b':
		sscanf(*argv,"%d",&bedSize);
		break; 	
	default:
	  printf( "\n\nunknown option: %c entered\n\n", option );
	  return FALSE;
	}
      } else {
	return FALSE;
      }
    }
  }

  if ( objPatient < 1 ) {
    return FALSE;
  }

  return TRUE;

}




