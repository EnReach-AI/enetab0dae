#ifndef FLUTTER_MY_APPLICATION_H_
#define FLUTTER_MY_APPLICATION_H_

#include <gtk/gtk.h>

G_BEGIN_DECLS

/**
 * my_application_get_type:
 *
 * Returns the type of the application.
 */
#define MY_APPLICATION_TYPE (my_application_get_type())

/**
 * MyApplication:
 *
 * The application class.
 */
G_DECLARE_FINAL_TYPE(MyApplication, my_application, MY, APPLICATION, GtkApplication)

/**
 * my_application_new:
 *
 * Creates a new application instance.
 *
 * Returns: a new application instance.
 */
MyApplication* my_application_new();

G_END_DECLS

#endif  // FLUTTER_MY_APPLICATION_H_
