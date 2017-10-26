#include <stdio.h>
 
int main()
{
   char text[1000], blank[1000];
   int c = 0, d = 0;
 
   printf("Enter some text\n");
   gets(text);
 
   while (text[c] != '\0') {
      if (text[c] == ' ') {
         int temp = c + 1;
         if (text[temp] != '\0') {
            while (text[temp] == ' ' && text[temp] != '\0') {
               if (text[temp] == ' ') {
                  c++;
               }  
               temp++;
            }
         }
      }
      blank[d] = text[c];
      c++;
      d++;
   }
 
   blank[d] = '\0';
 
   printf("Text after removing blanks\n%s\n", blank);
 
   return 0;
}