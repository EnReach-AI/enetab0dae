#ifndef FLUTTER_MY_APPLICATION_H_
#define FLUTTER_MY_APPLICATION_H_

#include <gtk/gtk.h>

G_BEGIN_DECLS

#define MY_APPLICATION_TYPE (my_application_get_type())
#define MY_APPLICATION(obj) \
  (G_TYPE_CHECK_INSTANCE_CAST((obj), MY_APPLICATION_TYPE, MyApplication))

typedef struct _MyApplication MyApplication;
typedef struct _MyApplicationClass MyApplicationClass;

GType my_application_get_type();

MyApplication* my_application_new();

G_END_DECLS

#endif  // FLUTTER_MY_APPLICATION_H_
