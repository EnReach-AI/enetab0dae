package utils

import "github.com/sirupsen/logrus"
func RecoverAndLog(funcName string) {
	if r := recover(); r != nil {
		logrus.WithField("func", funcName).WithField("panic", r).Error("panic recovered")
	}
}
