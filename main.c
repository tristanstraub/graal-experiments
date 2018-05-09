#include <stdlib.h>
#include <stdio.h>

#include "libproject.h"

int main(int argc, char **argv) {
  graal_isolate_t *isolate = NULL;
  graal_isolatethread_t *thread = NULL;

  if (graal_create_isolate(NULL, &isolate) != 0 || (thread = graal_current_thread(isolate)) == NULL) {
    fprintf(stderr, "initialization error\n");
    return 1;
  }

  int a = 1;
  int b = 2;

  printf("%i km\n", add2(thread, a, b));

  return 0;
}
